FROM stain/jena-fuseki

RUN apt-get update; \
    apt-get install -y --no-install-recommends procps

CMD dockerd --log-driver gcplogs
