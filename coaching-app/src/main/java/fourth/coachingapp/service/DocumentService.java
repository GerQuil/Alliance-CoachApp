package fourth.coachingapp.service;

import java.nio.file.FileSystems;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fourth.coachingapp.algorithms.LocalFileImpl;
import fourth.coachingapp.response.FailedException;

@Service
public class DocumentService
{
	Logger log = Logger.getLogger(DocumentService.class.getName());

	private String fs = FileSystems.getDefault().getSeparator();

	private String filePath = fs + "evidence";

	@Autowired
	private LocalFileImpl localFile;

	public void saveDocument(MultipartFile file, String entity, int id)
	{
		try
		{

			localFile.saveFile(file, filePath + fs + entity + fs + id);
		}
		catch (Exception e)
		{
			log.error("Error saving file", e);
		}
	}

	public byte [] getDocument(String entity, int id)
	{
		try
		{
			return localFile.getFile(filePath + fs + entity + fs + id);
		}
		catch (Exception e)
		{
			throw new FailedException("FINDING DOCUMENT WITH PATH " + filePath + fs + entity + fs + id);
		}
	}

	public void deleteDocument(int id, String entity)
	{
		try
		{
			localFile.deleteFile(filePath + fs + entity + fs + id);

		}
		catch (Exception e)
		{
			throw new FailedException("DELETING DOCUMENT WITH PATH " + filePath + fs + entity + fs + id);
		}
	}

}
