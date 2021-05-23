# NewsStories

Installation
You need to have Java 8 JDK installed along with maven. Git

I have used IntelliJ Windows OS

Cloning Git repositories
-Go to C:\ and then create a folder -Inside the folder, right click and choose ‘Git Bash Here’. You will see a bash window opened. -Inside the bash window type like this, git clone https://github.com/siri1710/NewsStories.git

Now navigate into project folders and do a git pull to make sure you get the most up to date source cd NewsStories git pull

To install all dependencies, run
$ mvn clean install

pre-requirements:
passing the credentials
Go to src->test->java->stepDefinitions->in stepdef class
for step @When("^User adds the credentials and send request$")
instead of abc/1234 pass the credential

To Run the tests:
Go to src->test->resource
you will see a freture file
Right click and select run feature file

Terminal shows the test pass 

