docker tag transaction-service:0.0.1 himanshusuman/transaction-service:v3
docker push himanshusuman/transaction-service:v7
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
kubectl delete rollout transaction-service -n transaction
kubectl get pods -n ingress-nginx
kubectl port-forward -n ingress-nginx pod/ingress-nginx-controller-657947f5c4-tq74w 8080:80
kubectl port-forward svc/argocd-server -n argocd 8080:443
LpEombTRvWh3ew-q