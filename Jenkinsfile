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

                        for (def file : changedFiles) {
                            def fileStatus = isNewOrModified(file, pythonDir)
                            echo "File $fileStatus: $file"
                            echo "Content of $file:"
                            echo readFile(file)
                        }


                    } else {
                        echo "Python code changes detected, but no specific files found."
                    }
                }
            }
        }

        stage('Java Changes') {
            when {
                changeset '**/Java/**'
            }
            steps {
                script {
                    // Specify the path to the Java directory
                    def javaDir = 'Java/'

                    // Get a list of changed files in the Java directory
                    def changedFiles = getChangedFiles(javaDir)

                    if (changedFiles) {
                        echo "Java code changes detected in the following files:"
                        echo changedFiles.join('\n')
                    } else {
                        echo "Java code changes detected, but no specific files found."
                    }
                }
            }
        }

        stage('C++ Changes') {
            when {
                changeset '**/C++/**'
            }
            steps {
                script {
                    // Specify the path to the C++ directory
                    def cppDir = 'C++/'

                    // Get a list of changed files in the C++ directory
                    def changedFiles = getChangedFiles(cppDir)

                    if (changedFiles) {
                        echo "C++ code changes detected in the following files:"
                        echo changedFiles.join('\n')
                    } else {
                        echo "C++ code changes detected, but no specific files found."
                    }
                }
            }
        }

        // Add more stages for other languages or actions as needed
    }
}

@NonCPS
List<String> getChangedFiles(String directory) {
    def changedFiles = []
    for (changeLogSet in currentBuild.changeSets) {
        for (entry in changeLogSet.getItems()) {
            // Check if the changed file is within the specified directory
            if (entry.affectedPaths.any { it.startsWith(directory) }) {
                changedFiles.addAll(entry.affectedPaths)
            }
        }
    }
    return changedFiles
}
@NonCPS
String isNewOrModified(String file, String directory) {
    def gitCommand = "git log --name-status -n 1 -- \"$file\""
    def commandOutput = bat(script: "cd \"$directory\" && $gitCommand", returnStdout: true).trim()

    return commandOutput.startsWith("A") ? "New File" : "Modified File"
}
