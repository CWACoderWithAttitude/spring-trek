#!/bin/sh

curl -i \
-H "Accept: application/json" \
-H "Content-Type:application/json" \
-X POST --data '{"name":"USS-Pathfinder", "sign":"42","type":"Constitution"}' \
http://dc-sb-prom.local:8080/ships




#ship={"name":"USS Defiant","sign":"NCC-1764","type":"Constitution"}
#curl -i \
#-H "Accept: application/json" \
#-H "Content-Type:application/json" \
#-X POST --data $ship \
#http://dc-sb-prom.local:8080/ships
