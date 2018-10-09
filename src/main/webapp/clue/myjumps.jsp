<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>等待跳转中......</title>

<style>
html, body {
	margin: 0;
	width: 100%;
	height: 100%;
	font-family: PingFang SC, Helvetica Neue, Hiragino Sans GB, Segoe UI,
		Microsoft YaHei, 微软雅黑, sans-serif;
	-webkit-font-smoothing: antialiased;
}

p {
	margin: 0 0 20px;
	padding: 0;
}

a {
	text-decoration: none;
	color: #5097E8;
}

.container {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100%;
	width: 100%;
}

.section {
	position: relative;
	max-width: 1200px;
	width: 100%;
	height: 600px;
	margin: 20px;
}

.logo {
	max-width: 175px;
	width: 100%;
}

.image-rectangle {
	position: absolute;
	width: 50%;
	height: 100%;
	right: 0;
	top: 0;
	z-index: 1;
	background-color: #76808E;
}

.image-square {
	display: none;
}

.word {
	display: flex;
	flex-direction: column;
	justify-content: center;
	width: 48%;
	height: 80%;
}

.slogan {
	color: #323A45;
	font-size: 20px;
}

.author-container {
	display: flex;
	align-items: center;
	color: #76808E;
	font-size: 18px;
	margin-top: 40px;
}

.dash {
	display: inline-block;
	width: 40px;
	height: 1px;
	background-color: #E3E5E8;
	margin-right: 6px;
}

.footer {
	position: absolute;
	bottom: 0;
	font-size: 14px;
	color: #76808E;
	width: 48%;
}

.jump {
	position: absolute;
	top: 20px;
	right: 20px;
	color: white;
	font-size: 14px;
	z-index: 2;
}

.small {
	font-size: 12px;
}

br {
	display: block;
	line-height: 1.5em;
	margin: 0.75em 0;
	content: " ";
}

@media ( max-width : 760px) {
	.container {
		align-items: flex-start;
		min-width: 320px;
	}
	.section {
		position: relative;
		width: 100%;
		height: 600px;
		max-width: 600px;
		margin: 20px;
	}
	.image-square {
		display: block;
		position: relative;
		width: 100%;
		margin-top: 50px;
	}
	.image-rectangle {
		display: none;
	}
	.word {
		display: block;
		position: relative;
		height: auto;
		width: 100%;
		margin-top: 20px;
		border-top: 1px solid #E3E5E8;
		padding-top: 30px;
	}
	.footer {
		position: relative;
		width: 100%;
		margin-top: 20px;
		border-top: 1px solid #E3E5E8;
		padding-top: 20px;
		padding-bottom: 40px;
	}
	.jump {
		position: relative;
		right: 0;
		top: 10px;
		float: right;
		color: #76808E;
	}
}

@media ( max-width : 400px) {
	.logo {
		max-width: 140px;
	}
	.jump {
		top: 5px;
	}
}
</style>
</head>

<body>
	<div class="container">
		<div class="section">
			<a href="${pageContext.request.contextPath}/user/login.jsp"> <img
				class="logo"
				src="${pageContext.request.contextPath}/images/501709.png">
			</a> <a class="jump">
				<div>马上访问网站...</div>
				<div class="small">
					<span class="remaining">10</span>S 后自动跳转
				</div>
			</a>
			<div class="word">
				<div class="slogan"></div>
				<div class="author-container">
					<span class="dash"></span> <span class="author"></span>
				</div>
			</div>
			<div class="image-rectangle"></div>
			<img class="image-square">
			<div class="footer">
				<div class="footer">马上跳转到 ~ IT精英俱乐部</div>
			</div>
		</div>
	</div>
	<div></div>
	<script>
        function randomIndex(length) {
            var seed = Math.random() * 100;
            return Math.floor(seed * seed % length);
        }

        function generateSlogan(slogan) {
            var html = '';

            for (var i = 0; i < slogan.length; i++) {
                html += '<p>' + slogan[i] + '</p>';
            }

            return html;
        }

        function getSearchParam(key) {
            var search = window.location.search;

            if (!search) {
                return '';
            }

            var reg = new RegExp('.*' + key + '=([^&]*)' + '.*');
            return decodeURIComponent(search.replace(reg, '$1') || '');
        }
    </script>
	<script>
        var DATA = [
            {
                author: '惠特曼',
                slogan: [
                    'O while I live to be the ruler of life, not a slave.',
                    '当我活着时，我要做生命的主宰，而不做它的奴隶。'
                ],
                image: 'https://dn-coding-net-production-pp.qbox.me/6e7c502e-36d8-42a0-9431-76a4b19186c3.png'
            },
            {
                author: '茨威格',
                slogan: [
                    'A life hit the biggest lucky, in his way of life midway,<br/>namely in the prime of life in he found his mission.',
                    '一个人生命中最大的幸运，莫过于在他的人生中途，<br/>即在他年富力强的时候发现了自己的使命。'
                ],
                image: 'https://dn-coding-net-production-pp.qbox.me/6ca538aa-229d-4331-85de-4630982f8f03.png'
            },
            {
                author: '海子',
                slogan: [
                    '陌生人，我也为你祝福，愿你有一个灿烂的前程；<br/>愿你有情人终成眷属；愿你在尘世获得幸福。<br/>我只愿面朝大海，春暖花开。'
                ],
                image: 'https://dn-coding-net-production-pp.qbox.me/134c29e7-4a72-4cf2-903e-45287115626d.png'
            },
            {
                author: '汪国真',
                slogan: [
                    '只是我喜欢笑，喜欢空气新鲜又明亮。<br/>我愿意像茶，把苦涩留在心底，散发出来的都是清香。'
                ],
                image: 'https://dn-coding-net-production-pp.qbox.me/2ad98568-75a8-4edc-8446-ae53acbffa0a.png'
            },
            {
                author: '李斯',
                slogan: [
                    '泰山不让土壤，故能成其大；河海不择细流，故能就其深。'
                ],
                image: 'https://dn-coding-net-production-pp.qbox.me/dc8a15cb-e3f3-4b0a-a89f-5c95dd3a4185.png'
            },
            {
                author: '安德烈·纪德',
                slogan: [
                    '我生活在妙不可言的等待中，等待随便哪种未来。'
                ],
                image: 'https://dn-coding-net-production-pp.qbox.me/63a76c71-b33b-4939-9804-ea984b007ca3.png'
            }
        ];

        var index = randomIndex(DATA.length);
        var data = DATA[index];
        var url = getSearchParam('redirect') || '${pageContext.request.contextPath}/user/login.jsp';

        document.querySelector('.author').innerHTML = data.author;
        document.querySelector('.slogan').innerHTML = generateSlogan(data.slogan);
        document.querySelector('.image-rectangle').style.backgroundImage = 'url(' + data.image + ')';
        document.querySelector('.image-square').src = data.image;
        document.querySelector('.jump').href = url;

        var remaining = 10;
        var interval = setInterval(function () {
            remaining--;
            if (remaining <= 0) {
                clearInterval(interval);
                document.querySelector('.small').innerHTML = '即将跳转...';
                window.location = url;
            } else {
                document.querySelector('.remaining').innerHTML = remaining;
            }
        }, 1000);
    </script>
	<!-- Google Analytics -->
	<script>
        setTimeout(function () {
            (function (i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                    m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
            ga('create', 'UA-65952334-1', 'auto');
            ga('require', 'linkid');
            ga('send', 'pageview');
        }, 0)
    </script>
</body>
</html>