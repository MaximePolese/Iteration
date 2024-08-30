#!/bin/bash

for i in {1..5}; do
  (
    curl -X POST -H "Content-Type: application/json" -d "$i" "http://localhost:8080/counters/1"
  ) &
done
wait