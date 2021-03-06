USE [PRJ301_Slot1_246]
GO
/****** Object:  Table [dbo].[AnualRequest]    Script Date: 6/15/2022 7:05:26 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AnualRequest](
	[rid] [int] IDENTITY(1,1) NOT NULL,
	[reason] [varchar](150) NOT NULL,
	[from] [date] NOT NULL,
	[to] [date] NOT NULL,
	[created_by] [int] NOT NULL,
	[reviewed_by] [int] NOT NULL,
	[status] [varchar](150) NOT NULL,
 CONSTRAINT [PK_AnualRequest] PRIMARY KEY CLUSTERED 
(
	[rid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dept]    Script Date: 6/15/2022 7:05:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dept](
	[did] [int] NOT NULL,
	[dname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Dept] PRIMARY KEY CLUSTERED 
(
	[did] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Emp]    Script Date: 6/15/2022 7:05:27 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Emp](
	[eid] [int] IDENTITY(1,1) NOT NULL,
	[ename] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NOT NULL,
	[did] [int] NULL,
 CONSTRAINT [PK_Emp] PRIMARY KEY CLUSTERED 
(
	[eid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Dept] ([did], [dname]) VALUES (1, N'Information Technology')
INSERT [dbo].[Dept] ([did], [dname]) VALUES (2, N'Accounting')
INSERT [dbo].[Dept] ([did], [dname]) VALUES (3, N'PR')
INSERT [dbo].[Dept] ([did], [dname]) VALUES (4, N'Human Resource Management')
INSERT [dbo].[Dept] ([did], [dname]) VALUES (5, N'Five')
GO
SET IDENTITY_INSERT [dbo].[Emp] ON 

INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1, N'mr A-UPDATED', 0, CAST(N'2002-08-23' AS Date), 2)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (2, N'ms B', 0, CAST(N'2002-10-05' AS Date), 2)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1002, N'1001', 1, CAST(N'2022-06-03' AS Date), 2)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1003, N'1002XXXX', 1, CAST(N'2022-06-03' AS Date), 2)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1005, N'XYXYXYXY', 0, CAST(N'2022-06-03' AS Date), 3)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1006, N'XYXYXYX', 0, CAST(N'2022-06-04' AS Date), 1)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1007, N'1100', 1, CAST(N'2022-06-03' AS Date), 2)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1008, N'Test', 1, CAST(N'2022-06-03' AS Date), 1)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1009, N'XXXXXXXXXXXXXXXXX', 0, CAST(N'2022-06-04' AS Date), 1)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (1010, N'GGGGGGGGGGGGG', 1, CAST(N'2022-06-03' AS Date), 1)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (2002, N'SEX', 0, CAST(N'2022-06-11' AS Date), 3)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (3002, N'mr A - UPDATED', 0, CAST(N'2002-08-23' AS Date), 2)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (4002, N'Five 1', 1, CAST(N'2022-06-09' AS Date), 5)
INSERT [dbo].[Emp] ([eid], [ename], [gender], [dob], [did]) VALUES (4003, N'Five 2', 0, CAST(N'2022-06-29' AS Date), 5)
SET IDENTITY_INSERT [dbo].[Emp] OFF
GO
ALTER TABLE [dbo].[AnualRequest]  WITH CHECK ADD  CONSTRAINT [FK_AnualRequest_Emp] FOREIGN KEY([created_by])
REFERENCES [dbo].[Emp] ([eid])
GO
ALTER TABLE [dbo].[AnualRequest] CHECK CONSTRAINT [FK_AnualRequest_Emp]
GO
ALTER TABLE [dbo].[AnualRequest]  WITH CHECK ADD  CONSTRAINT [FK_AnualRequest_Emp1] FOREIGN KEY([reviewed_by])
REFERENCES [dbo].[Emp] ([eid])
GO
ALTER TABLE [dbo].[AnualRequest] CHECK CONSTRAINT [FK_AnualRequest_Emp1]
GO
ALTER TABLE [dbo].[Emp]  WITH CHECK ADD  CONSTRAINT [FK_Emp_Dept] FOREIGN KEY([did])
REFERENCES [dbo].[Dept] ([did])
GO
ALTER TABLE [dbo].[Emp] CHECK CONSTRAINT [FK_Emp_Dept]
GO
