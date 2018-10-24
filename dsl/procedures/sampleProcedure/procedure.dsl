import java.io.File

def procName = 'Sample Procedure'
procedure procName, {

    step 'Setup',
        command: new File(pluginDir, "dsl/procedures/sampleProcedure/steps/setup.groovy").text,
        shell: 'ec-groovy'

    step 'sample step',
        command: new File(pluginDir, "dsl/procedures/sampleProcedure/steps/step1.groovy").text,
        shell: 'ec-groovy -cp $[classpath]'

}

