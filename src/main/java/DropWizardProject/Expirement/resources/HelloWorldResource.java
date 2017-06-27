package DropWizardProject.Expirement.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.NotEmpty;

import com.codahale.metrics.annotation.Timed;
import java.util.Optional;

import DropWizardProject.Expirement.api.Saying;
import io.dropwizard.jersey.params.NonEmptyStringParam;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;

	public HelloWorldResource(String template, String defaultName) {
		super();
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}

	@GET
	@Timed
	@Path("sayHello")
	public Saying sayHello(@QueryParam("name") Optional<String> name) {

		final String value = String.format(template, name.orElse(defaultName));

		return new Saying(counter.incrementAndGet(), value);

	}

	@GET
	@Timed
	@Path("splitName")
	public String[] splitName(@QueryParam("name") NonEmptyStringParam name) throws NullPointerException {

		if (name != null && name.get().isPresent()) {
			try {
				StringBuilder stringBuilder = new StringBuilder(name.get().get());

				String[] splitNames = new String[3];

				// Get last name
				int nextIndex, prevIndex = 0;
				nextIndex = stringBuilder.indexOf(",", prevIndex);
				String lastName = stringBuilder.substring(prevIndex, nextIndex);

				// Get first name
				prevIndex = nextIndex + 2;
				nextIndex = stringBuilder.indexOf(" ", prevIndex);
				String firstName = stringBuilder.substring(prevIndex, nextIndex);

				// Get middle name
				prevIndex = nextIndex + 1;
				String middleName = stringBuilder.substring(prevIndex, stringBuilder.length());

				// Put values in array
				splitNames[0] = firstName;
				splitNames[1] = middleName;
				splitNames[2] = lastName;

				return splitNames;

			} catch (Exception exception) {
				throw exception;
			}
		} else {
			throw new NullPointerException("Name is needed.");
		}

	}

}
