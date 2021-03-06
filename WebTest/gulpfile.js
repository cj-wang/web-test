var gulp = require('gulp');
var concat = require('gulp-concat');
var sourcemaps = require('gulp-sourcemaps');
var uglify = require('gulp-uglify');
var ngAnnotate = require('gulp-ng-annotate');
var plumber = require('gulp-plumber');

gulp.task('default', function() {
	console.log('gulp runs as expected');
});

gulp.task('build', function () {
	gulp.src(['src/main/resources/static/angular-walle/**/*.js'])
	.pipe(plumber())
//	.pipe(sourcemaps.init())
	.pipe(concat('angular-walle.js'))
//	.pipe(ngAnnotate())
//	.pipe(uglify())
//	.pipe(sourcemaps.write())
	.pipe(gulp.dest('target/classes/static'));

	gulp.src(['src/main/resources/static/angular-walle/**/*.css'])
	.pipe(plumber())
	.pipe(concat('angular-walle.css'))
	.pipe(gulp.dest('target/classes/static'));
	
	gulp.src(['src/main/resources/static/app/**/*.js'])
	.pipe(plumber())
//	.pipe(sourcemaps.init())
	.pipe(concat('app.js'))
//	.pipe(ngAnnotate())
//	.pipe(uglify())
//	.pipe(sourcemaps.write())
	.pipe(gulp.dest('target/classes/static'));
	
	gulp.src(['src/main/resources/static/css/**/*.css'])
	.pipe(plumber())
	.pipe(concat('app.css'))
	.pipe(gulp.dest('target/classes/static'));
});

gulp.task('watch', ['build'], function () {
	gulp.watch(['src/main/resources/static/**/*.js', 'src/main/resources/static/**/*.css'], ['build']);
});
