var gulp = require('gulp')
var concat = require('gulp-concat')
var sourcemaps = require('gulp-sourcemaps')
var uglify = require('gulp-uglify')
var ngAnnotate = require('gulp-ng-annotate')

gulp.task('default', function() {
	console.log('gulp runs as expected');
});

gulp.task('build', function () {
	gulp.src(['src/main/resources/static/views/**/*.js'])
	.pipe(sourcemaps.init())
	.pipe(concat('app.js'))
	.pipe(ngAnnotate())
	.pipe(uglify())
	.pipe(sourcemaps.write())
	.pipe(gulp.dest('target/classes/static'))
});

gulp.task('watch', function () {
	gulp.watch('src/main/resources/static/views/**/*.js', ['build'])
});
