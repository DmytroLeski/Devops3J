pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/DmytroLeski/Devops3.git'
            }
        }
        
        stage('Build Docker image') {
            steps {
                script {
                    def dockerImage = docker.build('DockerfileJ', '-f path/to/Dockerfile .')
                    dockerImage.push()
                }
            }
        }
        
        stage('Cleanup') {
            steps {
                sh 'docker system prune -f'
            }
        }
    }
}