package picocli.annotation.processing.tests;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import javax.annotation.processing.Processor;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

public class Issue2407Test
{
    //@Ignore("https://github.com/remkop/picocli/issues/2407")
    @Test
    public void testIssue2407() {
        Processor processor = new AnnotatedCommandSourceGeneratorProcessor();
        Compilation compilation =
            javac()
                .withProcessors(processor)
                .compile(JavaFileObjects.forResource(
                    "picocli/issue2407/Main.java"));

        assertThat(compilation).succeeded();
    }
}
