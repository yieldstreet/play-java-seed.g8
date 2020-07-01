#!/bin/sh
# build and deploy $name$ to the local k3d cluster
sbt $name$-play/docker:publishLocal || exit 1
k3d load image -c ys-dev-stack 283519872463.dkr.ecr.us-east-2.amazonaws.com/$name$:latest || exit 1
helm --kube-context=k3d-ys-dev-stack upgrade --install -f helm/$name;format="normalize"$/values/dev/values.yaml $name$ helm/$name;format="normalize"$ || exit 1
kubectl --context=k3d-ys-dev-stack rollout restart deployment/$name$
