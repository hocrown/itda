CREATE table itda_USER(
    userId VARCHAR2(15) not null PRIMARY KEY, 
    familySeq NUMBER(10),
    userPw VARCHAR2(20),
    userName VARCHAR2(20),
    userAge NUMBER(3),
    userSex VARCHAR2(10),
    userAddress VARCHAR2(20),
    userPhone NUMBER(12),
    approve VARCHAR2(2)
    )
    
create table family (
    familySeq NUMBER not null primary KEY,
    inviteCode VARCHAR2(6),
    family_owner VARCHAR2(15),
    FOREIGN KEY(family_owner) REFERENCES itda_USER(userId) ON DELETE CASCADE
    );


alter table itda_USER
ADD CONSTRAINT fk_family foreign KEY(familySeq) REFERENCES family(familySeq); 

CREATE TABLE poking(
    pokingSeq NUMBER(10) primary key,
    sender VARCHAR2(15),
    receiver VARCHAR2(15),
    poke_date DATE,
    FOREIGN KEY(sender) REFERENCES itda_USER(userId),
    FOREIGN KEY(receiver) REFERENCES itda_USER(userId)
    );
    
CREATE TABLE ALARM(
    alarmSeq NUMBER primary key,
    receiver VARCHAR2(15),
    alarm_date DATE,
    checked NUMBER(2),
    FOREIGN KEY(receiver) REFERENCES itda_USER(userId)
    );

CREATE TABLE dailyQuestion (
    dailyQuestionSeq NUMBER primary key,
    question CLOB NOT NULL,
    type VARCHAR2(10),
    familySeq NUMBER,
    FOREIGN KEY(familySeq) REFERENCES family(familySeq)
    );
    
CREATE TABLE familyQuestion(
    familyQuestionSeq NUMBER primary key,
    familyseq NUMBER, 
    dailyQuestionSeq NUMBER,
    answer VARCHAR2(2),
    FOREIGN KEY (familySeq) REFERENCES family(familySeq)
   );
   
CREATE TABLE dailyAnswer(
    dailyAnswerSeq NUMBER primary key,
    userId VARCHAR2(15),
    familySeq NUMBER,
    answer CLOB NOT NULL,
    ans_date date NOT NULL,
    FOREIGN KEY (userId) REFERENCES itda_user(userId)
    );
    
CREATE TABLE Timeline(
    timelineSeq NUMBER primary key,
    userId VARCHAR2(15),
    tl_content CLOB,
    emotion NUMBER,
    FOREIGN KEY (userId) REFERENCES itda_user(userId)
    );
    
CREATE TABLE TIMELINEREPLY(
    replySeq NUMBER,
    regDate date,
    replycontents CLOB,
    type VARCHAR2(10),
    timelineSeq NUMBER,
    FOREIGN KEY (timelineSeq) REFERENCES TIMELINE(timelineSeq)
    );
    
CREATE TABLE TLattach(
    filename VARCHAR2(150),
    timelineSeq NUMBER,
    regDate DATE,
    FOREIGN KEY (timelineSeq) REFERENCES TIMELINE(timelineSeq)
    );
    
CREATE TABLE EMOJI(
    emojiSeq NUMBER PRIMARY KEY,
    fileName VARCHAR2(235) null,
    fileSize VARCHAR2(45) null,
    fileContentType VARCHAR2(500) null,
    fileDATA BLOB null
    );
    
ALTER TABLE TIMELINE
ADD CONSTRAINT tl_emoji foreign KEY(emotion) REFERENCES emoji(emojiSeq); 

CREATE TABLE WHISPER (
    whisperSeq NUMBER PRIMARY KEY,
    sender VARCHAR2(15),
    receiver VARCHAR2(15),
    sendDate date,
    message CLOB,
    whispertype VARCHAR2(10),
    visible NUMBER(2) null,
    FOREIGN KEY (sender) REFERENCES itda_user(userId),
    FOREIGN KEY (receiver) REFERENCES itda_user(userId)
    );

CREATE TABLE BucketList(
    BucketSeq NUMBER PRIMARY KEY,
    userId VARCHAR2(15),
    regDate DATE,
    title VARCHAR2(1000),
	bucketContents CLOB,
    goalDate date,
    type VARCHAR2(10),
    FOREIGN KEY (userId) REFERENCES itda_user(userId)
    );
    
CREATE TABLE THUMBNAIL(
    thumbnailSeq NUMBER PRIMARY KEY,
    bno NUMBER,
    fileName VARCHAR2(235) null,
    fileSize VARCHAR2(45) null,
    fileCONTENTTYPE VARCHAR2(500) null,
    FILEDATA BLOB NULL,
    FOREIGN KEY (bno) REFERENCES BucketList (bucketSeq)
    );
    
CREATE TABLE bucketREPLY(
    bucketreplySeq NUMBER PRIMARY KEY,
    bno NUMBER,
    regDate date,
    replycontents CLOB,
    type VARCHAR2(10),
    timelineSeq NUMBER,
    FOREIGN KEY (bno) REFERENCES BucketList(BucketSeq)
    );
    
commit;