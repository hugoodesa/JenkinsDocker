pipeline {
    agent any

     tools {
      maven 'main_maven'
      jdk 'main_jdk'
    }

    stages {
        stage('build backend') {
            steps {
                sh 'mvn -DskipTests=true clean package'
            }
        }
        stage('unit test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            agent any
            steps {
              sh 'docker build -t calculator .'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('local_sonar') {
                    bat '''mvn clean verify sonar:sonar -Dsonar.projectKey=learnJenkins -Dsonar.projectName='learnJenkins' -Dsonar.host.url=http://172.18.0.2:9000''' //port 9000 is default for sonar
                    echo 'SonarQube Analysis Completed'
                }
            }
        }
        
    }

    post {
        success{
          sh 'cp /var/jenkins_home/workspace/PipeLine/target/calculator.war /app/dev/jenkins_home/calculator.war'
        }
        always {
            echo 'finished'
        }
    }
}
