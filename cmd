docker tag transaction-service:0.0.1-SNAPSHOT himanshusuman/transaction-service:v3
docker push himanshusuman/transaction-service:v3
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
kubectl delete rollout transaction-service -n transaction
kubectl get pods -n ingress-nginx
kubectl port-forward -n ingress-nginx pod/ingress-nginx-controller-xxxxxx-xxxxx 8080:80