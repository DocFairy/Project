<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>DocFairy-통합 문서 관리 시스템</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	<link rel="shortcut icon" href="images/favicon.ico" />
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/animate.css" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="css/swiper.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script src="javascript/pace.min.js"></script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include> 	
	<div class="container">
		<div class="row">
			<aside class="col-md-3 sidebar">
				<div class="block">
					<h3><span>Blog menu</span></h3>
					<nav>
						<ul class="nav">
							<li><a href="blog-index.html">Blog no sidebars</a>
							</li>
							<li class="active"><a href="blog-left-sidebar.html">Blog left sidebar</a>
							</li>
							<li><a href="blog-right-sidebar.html">Blog right sidebar</a>
							</li>
							<li><a href="blog-post.html">Blog post</a>
							</li>
						</ul>
					</nav>
				</div>
				<div class="block">
					<h3>Recent posts</h3>
					<div class="row recent-post">
						<div class="col-sm-5">
							<img src="images/recent-post-1.jpg" alt="" class="img-responsive">
						</div>
						<div class="col-sm-7 recent-text">
							<h5><a href="blog-post.html">Lorem ipsum dolor sit</a></h5>
							<time datetime="2016-03-03">March 3, 2016</time>
						</div>
					</div>
					<div class="row recent-post">
						<div class="col-sm-5">
							<img src="images/recent-post-2.jpg" alt="" class="img-responsive">
						</div>
						<div class="col-sm-7 recent-text">
							<h5><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h5>
							<time datetime="2016-05-03">May 3, 2016</time>
						</div>
					</div>
					<div class="row recent-post">
						<div class="col-sm-5">
							<img src="images/recent-post-1.jpg" alt="" class="img-responsive">
						</div>
						<div class="col-sm-7 recent-text">
							<h5><a href="blog-post.html">Lorem ipsum dolor sit</a></h5>
							<time datetime="2016-05-03">March 3, 2016</time>
						</div>
					</div>
				</div>
				<div class="block">
					<h3>Recent comments</h3>
					<blockquote>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
						<footer>Jean Dow in <cite title="Lunch table"><a href="blog-post.html">Lunch table</a></cite>
						</footer>
					</blockquote>
					<blockquote>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
						<footer>Jean Dow in <cite title="Lunch table"><a href="blog-post.html">Lunch table</a></cite>
						</footer>
					</blockquote>
				</div>
				<div class="block">
					<h3>Newsletter</h3>
					<form>
						<div class="animated-form-control form-group">
							<input type="email" name="email" class="form-control" placeholder="E-mail..." required="required" aria-required="true" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-block btn-custom">Subscribe Now</button>
						</div>
					</form>
				</div>
				<div class="block">
					<h3>About</h3>
					<img src="images/about.jpg" alt="" class="img-responsive">
					<div class="text">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit.</p>
					</div>
				</div>
				<div class="block">
					<h3>Tags</h3>
					<div class="tags">
						<a href="#" class="btn btn-default btn-xs">Vegetables</a>
						<a href="#" class="btn btn-default btn-xs">Food</a>
						<a href="#" class="btn btn-default btn-xs">Lunch</a>
						<a href="#" class="btn btn-default btn-xs">Carot</a>
						<a href="#" class="btn btn-default btn-xs">Gluten free</a>
					</div>
				</div>
				<div class="block">
					<h3>Keep in touch</h3>
					<p class="social">
						<a href="#"><i class="fa fa-facebook social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-twitter social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-instagram social-icon-small" aria-hidden="true"></i></a>
						<a href="#"><i class="fa fa-youtube social-icon-small" aria-hidden="true"></i></a>
					</p>
				</div>
			</aside>
			<div class="col-md-9">
				<article>
					<img src="images/blog-thumb-1.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">cabbage</a> <a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Lunch table</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">Jean Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-03-03">March 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-2.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">John Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-05-03">May 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-1.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">cabbage</a> <a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Lunch table</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">Jean Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-03-03">March 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-2.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">John Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-05-03">May 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-1.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">cabbage</a> <a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Lunch table</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">Jean Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-03-03">March 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>
				<article>
					<img src="images/blog-thumb-2.jpg" alt="" class="img-responsive">
					<div class="blog-post animateOnScroll" data-animation="fadeInUp">
						<div class="blog-post-header">
							<p class="categories"><a href="#">spring</a> <a href="#">vegetarian</a>
							</p>
							<h2><a href="blog-post.html">Aenean tincidunt rhoncus metus</a></h2>
							<div class="row">
								<div class="col-sm-6 blog-post-author">
									<i class="fa fa-user" aria-hidden="true"></i> <a href="#">John Dow</a>
								</div>
								<div class="col-sm-6 blog-post-date">
									<i class="fa fa-calendar" aria-hidden="true"></i>
									<time datetime="2016-05-03">May 3, 2016</time>
								</div>
							</div>
						</div>
						<div class="blog-post-body">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer quis pellentesque nunc, in rutrum velit. Integer finibus laoreet lectus at hendrerit. Aenean tincidunt rhoncus metus ac rutrum. Nunc lorem libero, iaculis sed scelerisque ac, porttitor in diam. Nam rhoncus ullamcorper neque ac auctor. Vivamus in mi tincidunt, eleifend nibh a, tincidunt sapien.</p>
						</div>
					</div>
				</article>

				<nav class="text-center">
					<ul class="pagination">
						<li>
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li class="active"><a href="#">1</a>
						</li>
						<li><a href="#">2</a>
						</li>
						<li><a href="#">3</a>
						</li>
						<li class="disabled"><a href="#">4</a>
						</li>
						<li><a href="#">5</a>
						</li>
						<li>
							<a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<footer class="page-footer">
		<div class="container">
			<div class="row">
				<div class="row-xs-12">
					<div class="divider"></div>
					<div class="text-center">
						<a href="index.html"><img src="images/logos/logo.png" alt="" class="logo">
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-9">
					<ul class="footer-links">
						<li><a href="#">Privacy Policy</a>
						</li>
						<li><a href="blog-index.html">Blog</a>
						</li>
						<li><a href="contact.html">Contact</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-3">
					<p>© ZUPA 2016</p>
				</div>
			</div>
		</div>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="javascript/animate-on-scroll.js"></script>
	<script src="javascript/script.js"></script>
</body>

</html>