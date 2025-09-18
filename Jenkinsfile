@Library("test") _
pipeline {
    agent {  label 'java'     }
    environment {
        TEXT = credentials('test_text')
    }
    stages {
        stage('build') {
            steps {
                bat 'mvn --version'
                bat 'mvn -B -DskipTests clean package'
            }
        }
        stage('test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Run JAR') {
            steps {
                bat 'java -jar target/demo-1.0-SNAPSHOT.jar %TEXT%'
            }
        }
        stage('Testing libraries'){
            steps{
                helloWorldExternal(name: "Dani", dayOfWeek: "Monday")
            }
        }
        stage('Main?'){
            when { branch 'main' }
            steps{ echo 'this is main'}
        }
        
    }
    post {
            success {
                script {
                    def COMMITTER_EMAIL = bat(
                    script: "git --no-pager show -s --format='%%ae'",
                    returnStdout: true).split('\r\n')[2].trim() 
                    echo "COMMITTER_EMAIL: ${COMMITTER_EMAIL}" 

                emailext(
                    to: COMMITTER_EMAIL,
                    subject: "✅ ${env.JOB_NAME} ${env.BRANCH_NAME} Build Successful}",
                    body: "The build was successful!}"
                    )
                }
            }
            failure {
                script {
                    def COMMITTER_EMAIL = bat(
                    script: "git --no-pager show -s --format='%%ae'",
                    returnStdout: true).split('\r\n')[2].trim() 
                    echo "COMMITTER_EMAIL: ${COMMITTER_EMAIL}" 

                emailext(
                    to: COMMITTER_EMAIL,
                    subject: "❌ ${env.JOB_NAME} ${env.BRANCH_NAME} Build Failed",
                    body: "The build has failed."
                    )
                }
            }
        }


}