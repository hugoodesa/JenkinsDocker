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
        /* stage('deploy tomcat'){
            steps{
                deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://172.19.0.2:8082')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        } */
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
