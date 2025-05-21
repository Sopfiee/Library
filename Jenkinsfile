pipeline {
    agent any

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

        stage('Test') {
            when {
                branch pattern: "feature/.*", comparator: "REGEXP"
            }
            steps {
                bat 'mvn test'
            }
        }

        stage('Static Analysis') {
            when {
                branch 'dev'
            }
            steps {
                bat 'mvn checkstyle:check'
            }
        }

        stage('Coverage') {
            steps {
                bat 'mvn jacoco:prepare-agent test jacoco:report'
            }
        }

        stage('Install if success') {
            steps {
                bat 'mvn install'
            }
        }

        stage('Copy artifact') {
            steps {
                bat 'copy target\\result.jar C:\\lib_jenkins'
            }
        }
    }
}
