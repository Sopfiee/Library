pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/your-user/your-repo.git'
    }

    stages {
        stage('Clone') {
            steps {
                echo 'Клонирование кода'
                // Jenkins сам клонирует код из SCM, шаг опциональный
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }
        
        stage('Checkout feature/4') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/feature/4']],
                    userRemoteConfigs: [[
                        url: "${REPO_URL}"
                    ]]
                ])
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Coverage') {
            steps {
                bat 'mvn -pl core clean test jacoco:report'
            }
        }

        stage('Checkout develop') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/develop']],
                    userRemoteConfigs: [[
                        url: "${REPO_URL}"
                    ]]
                ])
            }
        }

        stage('Static Analysis') {
            steps {
                bat 'mvn checkstyle:check'
            }
        }

        stage('Checkout master') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    userRemoteConfigs: [[
                        url: "${REPO_URL}"
                    ]]
                ])
            }
        }

        stage('Install if success') {
            steps {
                bat 'mvn install'
            }
        }

        stage('Copy artifact') {
            steps {
                bat 'copy ui\\target\\ui-1.0-jar-with-dependencies.jar C:\\lib_jenkins'
            }
        }
    }
}
