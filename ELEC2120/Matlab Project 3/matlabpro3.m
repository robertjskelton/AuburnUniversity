%define variables
t = -2*pi:0.1:2*pi;
syms x y;

%part a
t1=-1:1/10000:1;
x1=rectpuls(t1,.2);
plot(t1,x1);
f1=.2*sinc(.2*t/(2*pi));
plot(t,f1);

%part b
t2=-4:1/10000:4;
x2=rectpuls(t2,2);
plot(t2,x2);
f2=2*sinc(t/pi);
plot(t,f2);

%part c
t3=-40:1/10000:40;
x3=rectpuls(t3,20);
plot(t3,x3);
f3=20*sinc(10*t/pi);
plot(t,f3);