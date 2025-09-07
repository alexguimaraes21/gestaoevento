pipeline {
    agent any

    environment {
        // Altere para o seu registro e nome da imagem
        IMAGE_NAME = 'gestaoevento-api'
        VERSION = "1.0.${BUILD_NUMBER}" // Usando o número da build do Jenkins para versionar
    }

    stages {
        stage('Unit Test Application') {
            steps {
                echo 'Running unit tests...'
                sh './mvnw verify'
            }
        }
        stage('Build Application') {
            steps {
                echo 'Building the application...'
                sh './mvnw package -DskipTests'
            }
        }
        stage('Build & Push Docker Image') {
            steps {
                echo "Building Docker image: ${IMAGE_NAME}:${VERSION}"
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh '''
                        # Loga no Docker Registry usando as variáveis de ambiente injetadas
                        echo "$DOCKER_PASS" | docker login --username "$DOCKER_USER" --password-stdin

                        # Cria a imagem docker
                        docker build -t $DOCKER_USER/$IMAGE_NAME:$VERSION .

                        # Envia imagem para o Docker Hub
                        docker push $DOCKER_USER/$IMAGE_NAME:$VERSION
                        '''
                    }

                }
            }
        }
    }

    post {
        success {
            echo "Pipeline completed successfully! Docker image ${IMAGE_NAME}:${VERSION} pushed."
        }
        failure {
            echo "Pipeline failed! Check test results or build errors."
        }
        always {
            echo "Cleaning up Docker login..."
            sh 'docker logout'
        }
    }
}