pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh 'javac src/OOMSimulator.java -d .'
            }
        }

        stage('Run App with Heap Dump Enabled') {
            steps {
                sh '''
                    java -cp . \
                         -Xmx16g \
                         -XX:+HeapDumpOnOutOfMemoryError \
                         -XX:HeapDumpPath=heapdump.hprof \
                         OOMSimulator || true
                '''
            }
        }

        stage('Archive Heap Dump') {
            steps {
                archiveArtifacts artifacts: 'heapdump.hprof', allowEmptyArchive: true
            }
        }
    }
}
