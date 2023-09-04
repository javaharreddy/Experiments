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
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Python/']]]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]])

                dir('Python') {
                    script {
                        def changedFile = bat(returnStdout: true, script: 'git diff --name-only origin/main HEAD | findstr /R "^Python/"').trim()
                        
                        if (changedFile) {
                            echo "Changed Python file detected: $changedFile"
                            bat "curl -X POST -F 'file=@$changedFile' http://localhost:8080/upload"
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
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Java/']]]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]])

                dir('Java') {
                    script {
                        def changedFile = bat(returnStdout: true, script: 'git diff --name-only origin/main HEAD | findstr /R "^Java/"').trim()
                        
                        if (changedFile) {
                            echo "Changed Java file detected: $changedFile"
                            bat "curl -X POST -F 'file=@$changedFile' http://localhost:8080/upload"
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
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'CPP/']]]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]])

                dir('CPP') {
                    script {
                        def changedFile = bat(returnStdout: true, script: 'git diff --name-only origin/main HEAD | findstr /R "^CPP/"').trim()
                        
                        if (changedFile) {
                            echo "Changed CPP file detected: $changedFile"
                            bat "curl -X POST -F 'file=@$changedFile' http://localhost:8080/upload"
                        } else {
                            echo 'No changed CPP file detected'
                        }
                    }
                }
            }
        }
    }
}
