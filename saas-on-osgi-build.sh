echo "Build the main system..."
#cd saas-on-osgi-main/
mvn clean install


echo
echo "Build the depenancy services..."
echo
cd ../saas-on-osgi-services/
cd embedded-jetty/
mvn clean install

cd ../java.heroku.proxy.bundle/
mvn clean install

cd ../com.sa.osgi.ui/
mvn clean install

cd ../T1.com.sa.osgi.ui/
mvn clean install

cd ../T3.com.sa.osgi.ui/
mvn clean install
echo 
echo "DONE building all service bundles..."
echo