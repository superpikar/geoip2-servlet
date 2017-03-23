# geoip2-servlet
GeoIP2 Java API implementation in servlet, for API documentation please read here http://maxmind.github.io/GeoIP2-java/

### GeoIP2 account and license configuration
Put your userId and licenseKey of GeoIP2 account in `webapp/resources/config.properties`
```properties
userId=1234
licenseKey=yourlicensekey
```
 
### List of IP(s) you want to inspect
Put your list of IP you want to inspect in `webapp/resources/ipAddress.csv`.
This source code use 10 selected IP from 5 country in CSV format as follows : 
```csv
36.72.191.22,PT Telkom Indonesia
114.124.25.76,Telkomsel Indonesia
198.211.113.28,Digital Ocean United States
31.13.79.254,Facebook United States
118.122.142.60,China Telecom Sichuan
116.231.77.45,China Telecom Shanghai
103.206.98.123,Safehouse Cloud Inc Singapore
103.219.78.12,Netskope Singapore
59.152.128.12,CJ Hellovision South Korea
115.16.12.129,Korea Telecom
```

### How to run the project?
- Open eclipse
- Right click on project >> Run As >> Maven Install
- Right click on project >> Run As >> Run on Server   

### Screenshot
![alt text](screenshots/screenshot.png "Output")
