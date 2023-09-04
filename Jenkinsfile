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
                   
                    echo 'Python code changes detected'
                 
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
                   
                    echo 'Java code changes detected'
                  
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
                   
                    echo 'C++ code changes detected'
                    
                }
            }
        }
    }
}
