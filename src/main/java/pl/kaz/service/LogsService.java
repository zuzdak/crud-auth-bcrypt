package pl.kaz.service;

import org.springframework.stereotype.Service;

import pl.kaz.domain.Logs;
import pl.kaz.repository.LogsRepository;

@Service
public class LogsService implements LogsRepository {

	private LogsRepository logsRepository;
	
	
	
	public void setLogsRepository(LogsRepository logsRepository) {
		this.logsRepository = logsRepository;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Logs arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Logs> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Logs> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Logs> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logs findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Logs> S save(S logs) {
		// TODO Auto-generated method stub
		return logsRepository.save(logs);
	}

	@Override
	public <S extends Logs> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
