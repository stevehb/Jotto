#!/bin/bash

if [ $# -eq 0 ] then
        echo "USAGE: ./sort.sh [listname]"
        exit
fi

cat ${1} | awk '{ print length, $0 }' | sort -n | awk '{$1=""; print $0}' > ${1}_sorted.txt
