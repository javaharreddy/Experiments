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
                   
                    def pythonDir = 'Python/'

                    
                    def changedFiles = getChangedFiles(pythonDir)

                    if (changedFiles) {
                        echo "Python code changes detected in the following files:"
                        echo changedFiles.join('\n')


                        for (def file : changedFiles) {

                            if (file.contains("/Test")) {
                                def result = bat(script: "python $file", returnStatus: true)
                                if (result == 0) {
                                echo "Success: Python script executed successfully."
                                mail bcc: '', body: '''Hi
                                Successfully executed the code and tested ''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: '20951a1284@iare.ac.in'

                            } else {
                                 mail bcc: '', body: '''Hi
                                failured occur executing the code ''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: '20951a1284@iare.ac.in'
                                echo "Failure: Python script execution failed with exit code ${result}."
                            }

                                echo "Content of $file:"
                                echo readFile(file)
                            }
                        /*
                            def response = httpRequest acceptType: 'APPLICATION_JSON', contentType: 'APPLICATION_OCTETSTREAM',
                           httpMode: 'POST', multipartName: 'file', quiet: true,
                           responseHandle: 'NONE', timeout: null, uploadFile: "$file",
                           url: 'http://localhost:8080/upload'

                            if (response.status == 200) {
                               
                                echo "HTTP request was successful"
                                echo "Response: ${response}"
                            } else {
                                
                                echo "HTTP request failed with status code: ${response.status}"
                                echo "Response: ${response}"
                            }
                            */

                        }


                    } 
                    else {
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
                  
                    def javaDir = 'Java/'

                   
                    def changedFiles = getChangedFiles(javaDir)

                    if (changedFiles) {
                        echo "Java code changes detected in the following files:"
                        echo changedFiles.join('\n')
                        //def junitDir='Java/lib/junit-4.10.jar -d .'
                        for (def file : changedFiles) {
                                echo"in the java"
                                def compileResult = bat (script: "javac $file", returnStatus: true)
                                if (compileResult == 0) {
                                    /*if (file.contains("/Test")) {
                                        def executeResult = bat(script: "java -cp .;$junitDir $file.replace('.java', '')", returnStatus: true)
                                        if (executeResult == 0) {
                                        echo "Success: Java program executed successfully."
                                    } else {
                                        error "Failure: Java program execution failed with exit code $executeResult."
                                        }

                                    }*/
                                    eco "compilation successful"
                                    def classFile = file.replace('.java', '.class')
                                    def executeResult = bat(script: "java $classFile", returnStatus: true)
                                        if (executeResult == 0) {
                                        echo "Success: Java program executed successfully."
                                    } else {
                                        echo "Failure: Java program execution failed with exit code $executeResult."
                                        }

                                }
                                else {
                                        error "Failure: Java compilation failed with exit code ${compileResult}."
                                }

                          
                            echo "Content of $file:"
                            echo readFile(file)
                        }
                    }
                    else {
                        echo "Java code changes detected, but no specific files found."
                    }                  
                        /*
                            def response = httpRequest acceptType: 'APPLICATION_JSON', contentType: 'APPLICATION_OCTETSTREAM',
                           httpMode: 'POST', multipartName: 'file', quiet: true,
                           responseHandle: 'NONE', timeout: null, uploadFile: "$file",
                           url: 'http://localhost:8080/upload'

                            if (response.status == 200) {
                                
                                echo "HTTP request was successful"
                                echo "Response: ${response}"
                            } else {
                                
                                echo "HTTP request failed with status code: ${response.status}"
                                echo "Response: ${response}"
                            }
                        */

  
                        
                    } 
            }
                    
                
        }

        stage('CPP Changes') {
            when {
                changeset '**/CPP/**'
            }
            steps {
                script {
                   
                    def cppDir = 'CPP/'

                    
                    def changedFiles = getChangedFiles(cppDir)

                    if (changedFiles) {
                        echo "C++ code changes detected in the following files:"
                        echo changedFiles.join('\n')

                        for (def file : changedFiles) {
                            echo "Content of $file:"
                            echo readFile(file)
                        /*
                            def response = httpRequest acceptType: 'APPLICATION_JSON', contentType: 'APPLICATION_OCTETSTREAM',
                           httpMode: 'POST', multipartName: 'file', quiet: true,
                           responseHandle: 'NONE', timeout: null, uploadFile: "$file",
                           url: 'http://localhost:8080/upload'

                            if (response.status == 200) {
                               
                                echo "HTTP request was successful"
                                echo "Response: ${response}"
                            } else {
                              
                                echo "HTTP request failed with status code: ${response.status}"
                                echo "Response: ${response}"
                            }
                        */

                        }


                    } else {
                        echo "C++ code changes detected, but no specific files found."
                    }
                }
            }
        }

        
    }
}

@NonCPS
List<String> getChangedFiles(String directory) {
    def changedFiles = []
    for (changeLogSet in currentBuild.changeSets) {
        for (entry in changeLogSet.getItems()) {
          
            if (entry.affectedPaths.any { it.startsWith(directory) }) {
                changedFiles.addAll(entry.affectedPaths)
            }
        }
    }
    return changedFiles
}


//java -jar jenkins.war --httpPort=9191


