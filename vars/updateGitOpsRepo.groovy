def call(String gitopsRepo, String branch, String imageRepo, String imageTag) {
    sh """
        rm -rf airline-platform-gitops
        git clone -b ${branch} ${gitopsRepo}
        cd airline-platform-gitops

        sed -i 's|repository:.*|repository: ${imageRepo}|' backend/values.yaml
        sed -i 's|tag:.*|tag: "${imageTag}"|' backend/values.yaml

        git config user.name "Jenkins CI"
        git config user.email "jenkins@techianadict.online"

        git add backend/values.yaml
        git commit -m "Update backend image tag to ${imageTag}" || echo "No changes to commit"
        git push origin ${branch}
    """
}