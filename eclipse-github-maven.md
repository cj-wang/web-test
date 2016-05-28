# Eclipse + Github + Maven project setup

- In Eclipse, show view Git Repositories

 ![](eclipse-github-maven.files/git-repo.png)

- Click Clone button in Git Repositories view

 ![](eclipse-github-maven.files/git-repo-clone-button.png)

- Input URI: https://github.com/wcj3570/web-test.git , and your user/pass, Next then Finish

 ![](eclipse-github-maven.files/git-clone.png)

- Import Maven Project

 ![](eclipse-github-maven.files/import-menu.png)

 ![](eclipse-github-maven.files/import-project.png)

 ![](eclipse-github-maven.files/import-maven-project.png)

- Install walle dependencies
 ```bat
 cd [UserFolder]/git/web-test/dependencies
 install.bat
 ```
- Build project. Right click on project, Run as -> Maven build, Goals: `clean package -DskipTests`

 ![](eclipse-github-maven.files/maven-build-menu.png)

 ![](eclipse-github-maven.files/maven-build.png)

- Run gulp watch when developing. Run as -> Maven build, Goals: `com.github.eirslett:frontend-maven-plugin:gulp`, with Parameter `frontend.gulp.arguments = watch`

 ![](eclipse-github-maven.files/gulp-watch.png)

- Run as Java Application, Main class `org.walle.webtest.Application`

 ![](eclipse-github-maven.files/run-app.png)

- Visit [http://localhost:8080](http://localhost:8080)

