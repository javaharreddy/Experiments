pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your Git repository
                checkout scm
            }
        }

        stage('Python Changes') {
            when {
                changeset '**/Python/**'
            }
            steps {
                script {
                    // Specify the path to the Python directory
                    def pythonDir = 'Python/'

                    // Get a list of changed files in the Python directory
                    def changedFiles = getChangedFiles(pythonDir)

                    if (changedFiles) {
                        echo "Python code changes detected in the following files:"
                        echo changedFiles.join('\n')
                    } else {
                        echo "Python code changes detected, but no specific files found."
                    }
                }
            }
        }

        // Add stages for Java and C++ changes if needed
    }
}

// Function to get a list of changed files in a directory
def getChangedFiles(directory) {
    try {
        def gitCommand = "git diff --name-only origin/main HEAD | findstr /R \"^${directory}\""
        def result = bat(script: gitCommand, returnStatus: true, returnStdout: true).trim()
        
        if (result) {
            return result.tokenize('\n')
        } else {
            // If no changes were found in the top-level directory, check subdirectories
            def subdirectories = findSubdirectories(directory)
            def subdirectoryChanges = [:]

            for (subdir in subdirectories) {
                def subdirPath = "${directory}${subdir}/"
                def subResult = bat(script: "git diff --name-only origin/main HEAD | findstr /R \"^${subdirPath}\"", returnStatus: true, returnStdout: true).trim()
                if (subResult) {
                    subdirectoryChanges[subdirPath] = subResult.tokenize('\n')
                }
            }

            return subdirectoryChanges
        }
    } catch (Exception ex) {
        return null
    }
}

def findSubdirectories(directory) {
    def subdirectories = []
    def cmd = "dir /b /ad \"${directory}*\""
    def subdirList = bat(script: cmd, returnStatus: true, returnStdout: true).trim()
    
    subdirList.eachLine { subdir ->
        subdirectories.add(subdir)
    }
    
    return subdirectories
}

