package org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection;

import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.ComponentScan;
import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.ComponentScans;
import org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation.Configuration;

@Configuration
/**
 * We can define the annotation multiple ways
 */
//@ComponentScan("org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection")
//@ComponentScan("org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation")
//@ComponentScans({
//        @ComponentScan("org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection"),
//        @ComponentScan("org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection.annotation")
//})

@ComponentScan("org.pk.annotation_plus_reflection_real_time_examples.custom.dependencyinjection")
public class AppConfig {

}
