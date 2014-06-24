## Time Tracker
Created: 06/18/2014

Collaborators:

- [Bethany Armitage](https://github.com/bethgrace5)
- [Kevin Mershon](https://github.com/kevinmershon)

### Summary
Web application that efficiently tracks time and mileage costs billed to clients.

### Getting Started
#### Windows + Eclipse users:
1. Download [Apache Tomcat](http://tomcat.apache.org/) if you do not already have it installed and on your path. See the Tomcat usage instructions for how to start, stop, deploy, and undeploy.
  - This project is tested with version 6.0 and later.
2. Install the [m2eclipse](https://www.eclipse.org/m2e/) Eclipse plugin if you do not already have it installed.
3. In Eclipse, select Project > Import > Import... > Existing Maven Projects, and then choose this project.
4. To compile the project, select Run As > Maven build... and choose the `package` goal.
5. Deploy the `.war` file using Tomcat's web-based interface.

#### Mac OSX users on command-line:
1. Run `brew install tomcat maven` to ensure Tomcat and Maven are installed.
2. Start and stop tomcat using the `catalina` command.
3. To compile the project, run the `mvn package` command.
4. Deploy the `.war` file using Tomcat's web-based interface.
