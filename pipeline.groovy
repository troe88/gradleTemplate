node('LDW_node') {
    def failedJobName = ""

    stage('Initial') {
//        maven = tool 'apache-maven-3.3.9'
//        jdk = tool 'jdk8'
        try {
            git 'https://github.com/troe88/gradleTemplate.git'
        } catch (err) {
            echo "${err}"
        }
    }

    stage('create properties') {
        sh 'gradle clean compileTest generateProperties'
    }

    stage('smoke test') {
        try {
            sh 'gradle smoke cucumber'
        } catch (err) {
            echo "${err}"
        }
    }

    stage('single test') {
        try {
            sh 'gradle single -Ptags=@ID-2 cucumber'
        } catch (err) {
            echo "${err}"
        }
    }
}