#查询
SELECT * FROM grade;
SELECT *  FROM  student_copy LIMIT 0,2;
SELECT _num,MAX(_date) AS _date FROM grade GROUP BY _num;
SELECT COUNT(2) FROM grade WHERE _num=1;
SELECT DISTINCT * FROM grade

#插入
INSERT INTO student_copy(_name, _year) VALUES ('gy', '123');
INSERT INTO grade(_num,_math,_date) VALUES (3,25,'2020-11-26')

#删除
DELETE FROM student_copy WHERE  `_num`=123;

#改
UPDATE student_copy SET _name='gyu', _year=258 WHERE _name='gy2';

#插入指定数据
#如果grade没有记录："1","21","2020-11-26"，则将"1","21","2020-11-26"插入grade。
#dual：临时表
insert into grade(_num,_math,_date) SELECT "2","21","2020-11-26" FROM dual WHERE NOT EXISTS(SELECT * FROM grade WHERE _num="2");
insert into grade(_num,_math,_date)SELECT "1","21","2020-11-26" FROM grade WHERE NOT EXISTS(SELECT * FROM grade WHERE _num="1");
SELECT DISTINCT "2","21","2020-11-26" FROM dual
SELECT "2","21","2020-11-26" FROM dual


#连接（内连接、左连接、右连接）
SELECT s._num,s._name,s._year,g._math,g._date FROM student AS s INNER JOIN grade AS g ON s._num=g._num;
SELECT s._num,s._name,s._year,g._math,g._date FROM student AS s LEFT JOIN grade AS g ON s._num=g._num;
SELECT s._num,s._name,s._year,g._math,g._date FROM student AS s RIGHT JOIN grade AS g ON s._num=g._num;
SELECT s._num,s._name,s._year,g._math,g._date FROM student AS s OUTER grade AS g ON s._num=g._num;


#获取时间（格式2020-12-01 09:38:32）
SELECT Now() as PerDate;

#获取日期（格式：20-12-01）
SELECT DATE_FORMAT(NOW(),'%y-%m-%d') as PerDate;






