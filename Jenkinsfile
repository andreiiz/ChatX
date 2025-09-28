pipeline {
    agent any  // esegue la pipeline su qualsiasi nodo disponibile

    environment {
        // variabili d'ambiente
        APP_NAME = "my-app"
        VERSION = "1.0.0"
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Esegue i test automatici
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completata con successo!'
        }
        failure {
            echo 'Pipeline fallita!'
        }
    }
}
