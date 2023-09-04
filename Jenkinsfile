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
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Python/']]]],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]
                ])

                dir('Python') {
                    script {
                        def maxRetries = 3
                        def retryCount = 0
                        def changedFile = bat(script: 'git diff --name-only origin/main HEAD | findstr "^Python\\"', returnStatus: true).trim()
                        
                        while (retryCount < maxRetries) {
                            def result = bat(script: "curl.exe -X POST -F \"file=@$changedFile\" --max-time 60 http://localhost:8080/upload", returnStatus: true)
                            if (result == 0) {
                                break
                            } else {
                                retryCount++
                                sleep(time: 10, unit: 'SECONDS')
                            }
                        }

                        if (retryCount == maxRetries) {
                            error('HTTP request failed after multiple retries')
                        }

                        if (changedFile) {
                            echo "Changed Python file detected: $changedFile"
                        } else {
                            echo 'No changed Python file detected'
                        }
                    }
                }
            }
        }

        stage('Java Changes') {
            when {
                changeset '**/Java/**'
            }
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Java/']]]],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]
                ])

                dir('Java') {
                    script {
                        def maxRetries = 3
                        def retryCount = 0
                        def changedFile = bat(script: 'git diff --name-only origin/main HEAD | findstr "^Java\\"', returnStatus: true).trim()
                        
                        while (retryCount < maxRetries) {
                            def result = bat(script: "curl.exe -X POST -F \"file=@$changedFile\" --max-time 60 http://localhost:8080/upload", returnStatus: true)
                            if (result == 0) {
                                break
                            } else {
                                retryCount++
                                sleep(time: 10, unit: 'SECONDS')
                            }
                        }

                        if (retryCount == maxRetries) {
                            error('HTTP request failed after multiple retries')
                        }

                        if (changedFile) {
                            echo "Changed Java file detected: $changedFile"
                        } else {
                            echo 'No changed Java file detected'
                        }
                    }
                }
            }
        }

        stage('C++ Changes') {
            when {
                changeset '**/CPP/**'
            }
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'CPP/']]]],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]
                ])

                dir('CPP') {
                    script {
                        def maxRetries = 3
                        def retryCount = 0
                        def changedFile = bat(script: 'git diff --name-only origin/main HEAD | findstr "^CPP\\"', returnStatus: true).trim()
                        
                        while (retryCount < maxRetries) {
                            def result = bat(script: "curl.exe -X POST -F \"file=@$changedFile\" --max-time 60 http://localhost:8080/upload", returnStatus: true)
                            if (result == 0) {
                                break
                            } else {
                                retryCount++
                                sleep(time: 10, unit: 'SECONDS')
                            }
                        }

                        if (retryCount == maxRetries) {
                            error('HTTP request failed after multiple retries')
                        }

                        if (changedFile) {
                            echo "Changed C++ file detected: $changedFile"
                        } else {
                            echo 'No changed C++ file detected'
                        }
                    }
                }
            }
        }
    }
}
