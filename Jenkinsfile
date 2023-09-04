pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Python Changes') {
            when {
                changeset '**/Python/**'
            }
            steps {
                script {
                    def changedFile = bat(returnStdout: true, script: 'git diff --name-only origin/main HEAD | findstr /R "^Python/"').trim()

                    if (changedFile) {
                        echo "Changed Python file detected: $changedFile"
                        
                        def fileContent = readFile(changedFile)

                        sendHttpRequest(changedFile, fileContent)
                    } else {
                        echo 'No changed Python file detected'
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
                    def changedFile = bat(returnStdout: true, script: 'git diff --name-only origin/main HEAD | findstr /R "^Java/"').trim()

                    if (changedFile) {
                        echo "Changed Java file detected: $changedFile"
                        
                        def fileContent = readFile(changedFile)

                        sendHttpRequest(changedFile, fileContent)
                    } else {
                        echo 'No changed Java file detected'
                    }
                }
            }
        }

        stage('C++ Changes') {
            when {
                changeset '**/CPP/**'
            }
            steps {
                script {
                    def changedFile = bat(returnStdout: true, script: 'git diff --name-only origin/main HEAD | findstr /R "^CPP/"').trim()

                    if (changedFile) {
                        echo "Changed CPP file detected: $changedFile"
                        
                        def fileContent = readFile(changedFile)

                        sendHttpRequest(changedFile, fileContent)
                    } else {
                        echo 'No changed CPP file detected'
                    }
                }
            }
        }
    }
}

def sendHttpRequest(changedFile, fileContent) {
    def controllerUrl = 'http://localhost:8080/upload'
    
    def response = httpRequest(
        contentType: 'APPLICATION_FORM',
        httpMode: 'POST',
        requestBody: [
            file: [
                file: fileContent,
                filename: changedFile
            ]
        ],
        url: controllerUrl
    )
    
    if (response.status == 200) {
        echo "File uploaded successfully!"
    } else {
        error "Error uploading the file: HTTP Status ${response.status}"
    }
}
