## docker安装Prometheus
```
docker run -p 9090:9090 -v /prometheus-data \
prom/prometheus -config.file=/prometheus-data/prometheus.yml
```

Prometheus exporter的Node exporter是可以独立安装，用来测试的

```
docker run --name my-node-exporter -d -p 9100:9100 \
  -v "/proc:/host/proc:ro" \
  -v "/sys:/host/sys:ro" \
  -v "/:/rootfs:ro" \
  --net="host" \
  prom/node-exporter \
    -collector.procfs /host/proc \
    -collector.sysfs /host/sys \
    -collector.filesystem.ignored-mount-points "^/(sys|proc|dev|host|etc)($|/)"
```



![](https://img2018.cnblogs.com/blog/1231979/202002/1231979-20200211173257603-376372192.png)

```
http://192.168.0.110:9100/metrics
```






```
docker run -d -p 3000:3000 --name=grafana -v /data/grafana:/var/lib/grafana grafana/grafana
```