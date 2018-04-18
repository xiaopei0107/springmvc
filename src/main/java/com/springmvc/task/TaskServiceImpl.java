package com.springmvc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskServiceImpl implements ITaskService {

	@Scheduled(cron="0 0 0/1 * * ?")  //每5秒执行一次 
	@Override
	public void myTask() {
		System.out.println("启动定时器任务。。");		
	}

}
