import com.electriccloud.client.groovy.ElectricFlow

ElectricFlow ef = new ElectricFlow()
def loader = new Loader(ef)
def classpath = loader.getPropertySheet(System.getenv("COMMANDER_WORKSPACE"))
def delimeter = ':' // TODO windows

ef.setProperty(propertyName: '/myJob/classpath', value: classpath.join(delimeter))
// The next step declares command as "ec-groovy -cp classpath"


class Loader {
    ElectricFlow ef
    public static String root = '/myProject/properties/scripts/src/main/groovy'

    def Loader(ef) {
        this.ef = ef
    }

    def dumpPropertySheet(String propertyName, File destination) {
        destination.mkdir()
        println "Created directory $destination"
        def properties = ef.getProperties(path: "${root}/$propertyName")?.propertySheet?.property
        properties.each { prop ->
            if (prop.propertySheetId) {
                dumpPropertySheet("$propertyName/${prop.propertyName}", new File(destination, prop.propertyName))
            }
            else {
                File file = new File(destination, prop.propertyName + '.groovy')
                file.write(prop.value)
                println "Wrote file: $file"
            }
        }
    }

    def getPropertySheet(String destination) {
        def classpath = []
        def properties = ef.getProperties(path: root)?.propertySheet?.property
        properties.each { prop ->
            if (prop.propertySheetId) {
                dumpPropertySheet(prop.propertyName, new File(destination, prop.propertyName))
                classpath << prop.propertyName
            }
        }
        return classpath
    }



}
