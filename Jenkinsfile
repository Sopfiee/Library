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
                bat 'mvn -pl core clean test jacoco:report'
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
