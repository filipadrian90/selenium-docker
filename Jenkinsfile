pipeline {
    // master executor should be set to 0
    agent any
//     tools{
//         maven 'Maven 3.6.3'
//             }
    parameters{
        string(name: "APP_PORT", defaultValue: "4444", trim: false, description: "hub's port number")
    }
    stages {
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t="adrianfilip/selenium-docker" .'
            }
        }
        stage('Start Selenium Grid'){
            steps{
                sh "echo APP_PORT=$params.APP_PORT > .env"
                sh "docker-compose up -d hub chrome firefox"
            }
        }
        stage('Run Test'){
            steps{
                sh "docker-compose up toolsQA"
                //sh "docker-compose up search-module-firefox book-flight-module-chrome"
            }
        }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
// 			        bat "docker login --username=${user} --password=${pass}"
// 			        bat "docker push adrianfilip/selenium-docker:latest"
// 			    }
//             }
        }
    post{
        always{
            archiveArtifacts artifacts: 'tests-results/**'
            sh "docker-compose down"
        }
    }
}