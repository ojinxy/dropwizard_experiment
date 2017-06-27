package DropWizardProject.Expirement;

import DropWizardProject.Expirement.health.TemplateHealthCheck;
import DropWizardProject.Expirement.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardProjectApplication extends Application<DropWizardProjectConfiguration> {

	public static void main(final String[] args) throws Exception {
		new DropWizardProjectApplication().run(args);
	}

	@Override
	public String getName() {
		return "DropWizardProject";
	}

	@Override
	public void initialize(final Bootstrap<DropWizardProjectConfiguration> bootstrap) {
		// TODO: application initialization
	}

	@Override
	public void run(final DropWizardProjectConfiguration configuration, final Environment environment) {
		HelloWorldResource helloWorldResource = new HelloWorldResource(configuration.getTemplate(),
				configuration.getDefaultName());

		TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(configuration.getTemplate());

		environment.healthChecks().register("template", templateHealthCheck);

		environment.jersey().register(helloWorldResource);
	}

}
