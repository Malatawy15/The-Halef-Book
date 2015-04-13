#!/bin/bash

CLASS="org.speechforge.cairo.server.resource.ResourceServerImpl"
bash launch.sh $CLASS -sipPort 5050 -sipTransport udp
