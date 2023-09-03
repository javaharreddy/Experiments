pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out the code from the Git repository
                checkout scm
            }
        }

        stage('Python Changes') {
            when {
                changeset '**/Python/**'
            }
            steps {
                // Check out the Python code
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Python/']]]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]])

                // Navigate to the Python directory
                dir('Python') {
                    // Add steps for Python code changes
                    echo 'Python code changes detected'
                    // You can run Python tests or other actions here
                }
            }
        }

        stage('Java Changes') {
            when {
                changeset '**/Java/**'
            }
            steps {
                // Check out the Java code
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'Java/']]]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]])

                // Navigate to the Java directory
                dir('Java') {
                    // Add steps for Java code changes
                    echo 'Java code changes detected'
                    // You can run Java builds, tests, etc., here
                }
            }
        }

        stage('C++ Changes') {
            when {
                changeset '**/CPP/**'
            }
            steps {
                // Check out the C++ code
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: [[path: 'CPP/']]]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'your-credentials-id', url: 'https://github.com/vemulasaikrishna03/Experiments.git']]])

                // Navigate to the C++ directory
                dir('CPP') {
                    // Add steps for C++ code changes
                    echo 'C++ code changes detected'
                    // You can compile and test C++ code here
                }
            }
        }
    }
}
