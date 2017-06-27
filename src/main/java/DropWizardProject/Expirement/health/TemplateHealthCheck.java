package DropWizardProject.Expirement.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {

	private final String template;
	
	
	public TemplateHealthCheck(String template) {
		super();
		this.template = template;
	}


	@Override
	protected Result check() throws Exception {
		final String saying = String.format(template, "TEST");
		
		if(! saying.contains("TEST")){
			return Result.unhealthy("Template does not contain TEST");
		}else{
			return Result.healthy();
		}
	}

}
