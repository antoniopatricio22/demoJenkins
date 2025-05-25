pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'
        jdk 'Java 21'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/antoniopatricio22/demoJenkins.git'
            }
        }

        stage('Compilar') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Testar') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Empacotar') {
            steps {
                bat 'mvn package'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
